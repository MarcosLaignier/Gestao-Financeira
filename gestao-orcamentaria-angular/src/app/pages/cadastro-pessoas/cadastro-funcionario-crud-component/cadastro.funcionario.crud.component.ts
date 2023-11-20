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

@Component({
  selector: 'cadastro-funcionario',
  templateUrl: './cadastro.funcionario.crud.component.html',
  styleUrls: ['./cadastro.funcionario.crud.component.scss']
})
export class CadastroFuncionarioCrudComponent extends AbstractCrud<Funcionario,any>  {

  @ViewChild("mainForm",{static:false}) mainForm: DxFormComponent

  Mode:ModeEnum = ModeEnum.List



  funcionario:Funcionario;
  protected readonly ModeEnum = ModeEnum;
  situacaoAtivoInativo:string[] = Object.values(SituacaoAtivoInativoEnum);

  constructor(private injector:Injector,
              private mainService:FuncionarioService,
              private router: Router) {
    super(injector,"/cadastro-funcionario");

  }


  protected override doOnInit() {
    if(this.model == null){
      this.model = new Funcionario()
      this.model.situacao = true
    }
    super.doOnInit();
  }


  override doClear(){
    this.mainForm.instance.resetValues()
  }

  novaLoja() {
    // this.router.navigate(['pages', 'cadastro-receita'])
    this.Mode = ModeEnum.Edit
  }


  override beforeDoSave(): Observable<any> | null {
    return super.beforeDoSave();
  }

  override getMainService(): any {
    return this.mainService;
  }
}
