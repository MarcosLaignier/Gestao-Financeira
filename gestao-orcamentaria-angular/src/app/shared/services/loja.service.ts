import {Injectable} from "@angular/core";
import {AbstractCrudService} from "./abstract.crud.service";
import {Funcionario} from "../model/funcionario";
import {HttpClient} from "@angular/common/http";
import {Loja} from "../model/loja";

@Injectable()
export class LojaService extends AbstractCrudService<Loja, any> {

  constructor(http: HttpClient) {
    super(http, "loja");
  }
}
