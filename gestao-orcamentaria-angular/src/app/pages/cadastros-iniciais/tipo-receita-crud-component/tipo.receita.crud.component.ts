import {Component, Injector, ViewChild} from "@angular/core";
import {TipoReceita} from "../../../shared/model/tipo.receita";
import {TipoReceitaService} from "../../../shared/services/tipo.receita.service";
import {AbstractCrud} from "../../../shared/crud/abstract.crud";
import {DxFormComponent} from "devextreme-angular";
import {ModeEnum} from "../../../shared/enum/mode.enum";
import {Router} from "@angular/router";
import {Observable} from "rxjs";
import {SituacaoAtivoInativoEnum} from "../../../shared/enum/situacao.ativo.inativo.enum";
import {CrudComponent} from "../../../shared/components/base-crud/crud.component";

@Component({
  selector: 'tipo-receita',
  templateUrl: './tipo.receita.crud.component.html',
  styleUrls: ['./tipo.receita.crud.component.scss']
})
export class TipoReceitaCrudComponent extends AbstractCrud<TipoReceita,any>  {

  @ViewChild("mainForm",{static:false}) mainForm: DxFormComponent
  @ViewChild("crud",{static:false}) crud: CrudComponent

  Mode:ModeEnum;

  tipoReceita:TipoReceita;
  protected readonly ModeEnum = ModeEnum;
  situacaoAtivoInativo:string[] = Object.values(SituacaoAtivoInativoEnum);

  constructor(private injector:Injector,
              private mainService:TipoReceitaService,
              private router: Router) {
    super(injector,"/cadastro-receita");

  }


  protected override doOnInit() {
    super.doOnInit();
    if(this.model == null){
      this.model = new TipoReceita()
      this.model.situacao = true

    }
    this.router.url.includes('create') || this.router.url.includes('edit') ?
      this.Mode = ModeEnum.Edit : this.Mode = ModeEnum.List;


    if(this.router.url.includes('edit')){
      this.findByID(this.router.url.split('/').pop()!)

    }

  }

  findByID(id:string){
    this.mainService.getById(id).subscribe(resp => {
      this.model = resp.body
    })
  }

  override doClear(){
    this.mainForm.instance.resetValues()
  }

  novaReceita() {
    this.router.navigate(['cadastro-receita', 'create'])
  }

  override beforeDoSave(): Observable<any> | null {
    return super.beforeDoSave();
  }

  override getMainService(): any {
    return this.mainService;
  }
}
