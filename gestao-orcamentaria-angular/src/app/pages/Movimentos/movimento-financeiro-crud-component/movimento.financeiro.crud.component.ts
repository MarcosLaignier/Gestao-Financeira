import {Component, Injector, ViewChild} from "@angular/core";
import {TipoReceita} from "../../../shared/model/tipo.receita";
import {TipoReceitaService} from "../../../shared/services/tipo.receita.service";
import {AbstractCrud} from "../../../shared/crud/abstract.crud";
import {DxFormComponent} from "devextreme-angular";
import {ModeEnum} from "../../../shared/enum/mode.enum";
import {Router} from "@angular/router";
import {Observable} from "rxjs";
import {MovimentoFinanceiro} from "../../../shared/model/movimento.financeiro";
import {TipoMovimentoEnum} from "../../../shared/enum/tipo.movimento.enum";
import {TipoDespesa} from "../../../shared/model/tipo.despesa";
import {MovimentoFinanceiroService} from "../../../shared/services/movimento.financeiro.service";
import {TipoDespesaService} from "../../../shared/services/tipo.despesa.service";
import {ReferenciaEnum} from "../../../shared/enum/referencia.enum";

@Component({
  selector: 'tipo-receita',
  templateUrl: './movimento.financeiro.crud.component.html',
  styleUrls: ['./movimento.financeiro.crud.component.scss']
})
export class MovimentoFinanceiroCrudComponent extends AbstractCrud<MovimentoFinanceiro,any>  {

  @ViewChild("mainForm",{static:false}) mainForm: DxFormComponent

  Mode:ModeEnum = ModeEnum.List



  movimentoFinanceiro:MovimentoFinanceiro;
  protected readonly ModeEnum = ModeEnum;
  tipoMovimento:string[] = Object.values(TipoMovimentoEnum);
  referencia:string[] = Object.values(ReferenciaEnum);

  tipoMovimentoRefType = TipoMovimentoEnum;

  tipoReceitaDataSource: TipoReceita[];
  tipoDespesaDataSource: TipoDespesa[];
  constructor(private injector:Injector,
              private mainService:MovimentoFinanceiroService,
              private tipoReceitaService:TipoReceitaService,
              private tipoDespesaService:TipoDespesaService,
              private router: Router) {
    super(injector,"/movimentoFinanceiro");

  }


  protected override doOnInit() {
    if(this.model == null){
      this.model = new MovimentoFinanceiro();
      this.model.dataMovimento = new Date();
    }

    this.router.url.includes('create') || this.router.url.includes('edit') ?
      this.Mode = ModeEnum.Edit : this.Mode = ModeEnum.List;


    if(this.router.url.includes('edit')){
      this.findByID(this.router.url.split('/').pop()!)

    }
    super.doOnInit();
  }

  onChangeTipoMovimento(event: any){
    console.log(event)
    if (event == TipoMovimentoEnum.RECEITA){
      this.carregaReceitas();
    }else if(event == TipoMovimentoEnum.DESPESA){
      this.carregaDespesas();

    }
  }
  carregaReceitas(){
    return this.tipoReceitaService.getAll().subscribe( resp => this.tipoReceitaDataSource = resp.body)
  }

  carregaDespesas(){
    return this.tipoDespesaService.getAll().subscribe( resp => this.tipoDespesaDataSource = resp.body)
  }


  despesaChange(tipoReceita:TipoReceita){
  }
  atualizaValorDigitado(event:any){
    if(this.model.tipoReceita != null && this.model.tipoReceita.temTaxa){
      this.model.valorTotal = parseFloat((this.model.valorDigitado - ((this.model.valorDigitado * this.model.tipoReceita.percentualTaxa)/100)).toFixed(2));
    }else{
      this.model.valorTotal = this.model.valorDigitado
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

  novaLoja() {
    this.router.navigate(['movimentos-financeiros', 'create'])
  }

  override beforeDoSave(): Observable<any> | null {
    return super.beforeDoSave();

  }

  override getMainService(): any {
    return this.mainService;
  }
}
