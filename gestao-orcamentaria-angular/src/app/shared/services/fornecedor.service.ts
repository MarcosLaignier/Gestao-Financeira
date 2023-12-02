import {AbstractCrudService} from "./abstract.crud.service";
import {HttpClient} from "@angular/common/http";
import {Injectable} from "@angular/core";
import {Funcionario} from "../model/funcionario";
import {Fornecedor} from "../model/fornecedor";

@Injectable()
export class FornecedorService extends AbstractCrudService<Fornecedor, any> {

  constructor(http: HttpClient) {
    super(http, "fornecedor");
  }
}
