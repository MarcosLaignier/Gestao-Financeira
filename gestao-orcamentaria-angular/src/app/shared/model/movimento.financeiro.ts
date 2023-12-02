import {TipoDespesa} from "./tipo.despesa";
import {TipoReceita} from "./tipo.receita";
import {TipoMovimentoEnum} from "../enum/tipo.movimento.enum";
import {ReferenciaEnum} from "../enum/referencia.enum";

export class MovimentoFinanceiro{
  id: number;
  dataMovimento:any;
  tipoMovimento:TipoMovimentoEnum;
  referencia:ReferenciaEnum;
  tipoDespesa: TipoDespesa;
  tipoReceita: TipoReceita;
  valorDigitado: number;
  valorTotal: number;
  versao: number;


}
