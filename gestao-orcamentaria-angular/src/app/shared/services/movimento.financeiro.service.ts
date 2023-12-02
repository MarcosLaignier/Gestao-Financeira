import {AbstractCrudService} from "./abstract.crud.service";
import {HttpClient} from "@angular/common/http";
import {Injectable} from "@angular/core";
import {Funcionario} from "../model/funcionario";
import {Fornecedor} from "../model/fornecedor";
import {MovimentoFinanceiro} from "../model/movimento.financeiro";

@Injectable()
export class MovimentoFinanceiroService extends AbstractCrudService<MovimentoFinanceiro, any> {

  constructor(http: HttpClient) {
    super(http, "movimento-financeiro");
  }
}
