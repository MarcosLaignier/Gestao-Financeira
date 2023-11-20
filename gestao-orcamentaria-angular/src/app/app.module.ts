import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { SideNavOuterToolbarModule, SideNavInnerToolbarModule, SingleCardModule } from './layouts';
import { FooterModule, ResetPasswordFormModule, CreateAccountFormModule, ChangePasswordFormModule, LoginFormModule } from './shared/components';
import { AuthService, ScreenService, AppInfoService } from './shared/services';
import { UnauthenticatedContentModule } from './unauthenticated-content';
import { AppRoutingModule } from './app-routing.module';
import {
  TipoReceitaCrudComponent
} from "./pages/cadastros-iniciais/tipo-receita-crud-component/tipo.receita.crud.component";
import {CrudComponent} from "./shared/components/base-crud/crud.component";
import {DevExtremeModule} from "devextreme-angular";
import {TipoReceita} from "./shared/model/tipo.receita";
import {TipoReceitaService} from "./shared/services/tipo.receita.service";
import {HttpClient, HttpClientModule} from "@angular/common/http";
import {FormsModule} from "@angular/forms";
import {
  TipoDespesaCrudComponent
} from "./pages/cadastros-iniciais/tipo-despesa-crud-component/tipo.despesa.crud.component";
import {TipoDespesaService} from "./shared/services/tipo.despesa.service";
import {FuncionarioService} from "./shared/services/funcionario.service";
import {
  CadastroFuncionarioCrudComponent
} from "./pages/cadastro-pessoas/cadastro-funcionario-crud-component/cadastro.funcionario.crud.component";
import {
  CadastroFornecedorCrudComponent
} from "./pages/cadastro-pessoas/cadastro-fornecedor-crud-component/cadastro.fornecedor.crud.component";
import {FornecedorService} from "./shared/services/fornecedor.service";
import {
  MovimentoFinanceiroCrudComponent
} from "./pages/Movimentos/movimento-financeiro-crud-component/movimento.financeiro.crud.component";
import {MovimentoFinanceiroService} from "./shared/services/movimento.financeiro.service";

@NgModule({
  declarations: [
    AppComponent,
    TipoReceitaCrudComponent,
    TipoDespesaCrudComponent,
    CadastroFuncionarioCrudComponent,
    CadastroFornecedorCrudComponent,
    MovimentoFinanceiroCrudComponent,
    CrudComponent
  ],
  imports: [
    BrowserModule,
    SideNavOuterToolbarModule,
    SideNavInnerToolbarModule,
    SingleCardModule,
    FooterModule,
    ResetPasswordFormModule,
    CreateAccountFormModule,
    ChangePasswordFormModule,
    LoginFormModule,
    UnauthenticatedContentModule,
    AppRoutingModule,
    DevExtremeModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [
    AuthService,
    ScreenService,
    AppInfoService,
    TipoReceitaService,
    TipoDespesaService,
    FuncionarioService,
    FornecedorService,
    MovimentoFinanceiroService

  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
