import {Component, Injector, ViewChild} from "@angular/core";
import {DxFormComponent} from "devextreme-angular";
import {Router} from "@angular/router";
import {Observable} from "rxjs";
import {Loja} from "../../shared/model/loja";
import {AbstractCrud} from "../../shared/crud/abstract.crud";
import { ModeEnum } from "src/app/shared/enum/mode.enum";
import {LojaService} from "../../shared/services/loja.service";
import {SituacaoAtivoInativoEnum} from "../../shared/enum/situacao.ativo.inativo.enum";

@Component({
  selector: 'loja',
  templateUrl: './loja.crud.component.html',
  styleUrls: ['./loja.crud.component.scss']
})
export class LojaCrudComponent extends AbstractCrud<Loja,any>  {

  @ViewChild("mainForm",{static:false}) mainForm: DxFormComponent

  Mode:ModeEnum = ModeEnum.List

  loja:Loja;
  lojaSelecionada:Loja;
  protected readonly ModeEnum = ModeEnum;
  situacaoAtivoInativo:string[] = Object.values(SituacaoAtivoInativoEnum);


  constructor(private injector:Injector,
              private mainService:LojaService,
              private router: Router) {
    super(injector,"/loja");

  }


  protected override doOnInit() {
    if(this.model == null){
      this.model = new Loja()
      this.model.situacao = true

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
    this.router.navigate(['loja', 'create'])
  }

  findByID(id:string){
    this.mainService.getById(id).subscribe(resp => {
      this.model = resp.body
    })
  }

  override beforeDoSave(): Observable<any> | null {
    console.log(this.model)
    return super.beforeDoSave();
  }

  override getMainService(): any {
    return this.mainService;
  }

  edit(event: any) {
    if(event && event.key){
      this.lojaSelecionada = event.key
      this.router.navigate(['loja', 'edit', this.lojaSelecionada.id])

    }
  }
}
