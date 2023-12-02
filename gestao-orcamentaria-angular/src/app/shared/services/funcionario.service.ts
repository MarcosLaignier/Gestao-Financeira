import {AbstractCrudService} from "./abstract.crud.service";
import {HttpClient} from "@angular/common/http";
import {Injectable} from "@angular/core";
import {Funcionario} from "../model/funcionario";

@Injectable()
export class FuncionarioService extends AbstractCrudService<Funcionario, any> {

  constructor(http: HttpClient) {
    super(http, "funcionario");
  }
}
