import {Component, Injector, ViewChild} from "@angular/core";
import {TipoReceita} from "../../../shared/model/tipo.receita";
import {TipoReceitaService} from "../../../shared/services/tipo.receita.service";
import {AbstractCrud} from "../../../shared/crud/abstract.crud";
import {DxFormComponent} from "devextreme-angular";
import {ModeEnum} from "../../../shared/enum/mode.enum";
import {Router} from "@angular/router";
import {Observable} from "rxjs";
import {SituacaoAtivoInativoEnum} from "../../../shared/enum/situacao.ativo.inativo.enum";
import {Funcionario} from "../../../shared/model/funcionario";
import {FuncionarioService} from "../../../shared/services/funcionario.service";
import {Fornecedor} from "../../../shared/model/fornecedor";
import {FornecedorService} from "../../../shared/services/fornecedor.service";

@Component({
  selector: 'cadastro-funcionario',
  templateUrl: './cadastro.fornecedor.crud.component.html',
  styleUrls: ['./cadastro.fornecedor.crud.component.scss']
})
export class CadastroFornecedorCrudComponent extends AbstractCrud<Fornecedor,any>  {

  @ViewChild("mainForm",{static:false}) mainForm: DxFormComponent

  Mode:ModeEnum = ModeEnum.List



  fornecedor:Fornecedor;
  fornecedorSelecionado: Fornecedor;
  protected readonly ModeEnum = ModeEnum;
  situacaoAtivoInativo:string[] = Object.values(SituacaoAtivoInativoEnum);

  constructor(private injector:Injector,
              private mainService:FornecedorService,
              private router: Router) {
    super(injector,"/cadastro-fornecedor");

  }


  protected override doOnInit() {
    if(this.model == null){
      this.model = new Fornecedor()
    }

    this.router.url.includes('create') || this.router.url.includes('edit') ?
      this.Mode = ModeEnum.Edit : this.Mode = ModeEnum.List;


    if(this.router.url.includes('edit')){
      this.findByID(this.router.url.split('/').pop()!)

    }
    super.doOnInit();
  }


  override doClear(){
    this.mainForm.instance.resetValues()
  }

  novaLoja() {
    this.router.navigate(['cadastro-fornecedor', 'create'])
  }

  findByID(id:string){
    this.mainService.getById(id).subscribe(resp => {
      this.model = resp.body
    })
  }


  override beforeDoSave(): Observable<any> | null {
    return super.beforeDoSave();
  }

  override getMainService(): any {
    return this.mainService;
  }

  edit(event: any) {
    if(event && event.key){
      this.fornecedorSelecionado = event.key
      this.router.navigate(['cadastro-fornecedor', 'edit', this.fornecedorSelecionado.id])

    }
  }
}
