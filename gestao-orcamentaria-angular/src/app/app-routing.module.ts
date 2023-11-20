import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginFormComponent, ResetPasswordFormComponent, CreateAccountFormComponent, ChangePasswordFormComponent } from './shared/components';
import { AuthGuardService } from './shared/services';
import { HomeComponent } from './pages/home/home.component';
import { ProfileComponent } from './pages/profile/profile.component';
import { TasksComponent } from './pages/tasks/tasks.component';
import { DxDataGridModule, DxFormModule } from 'devextreme-angular';
import {
  TipoReceitaCrudComponent
} from "./pages/cadastros-iniciais/tipo-receita-crud-component/tipo.receita.crud.component";
import {
  TipoDespesaCrudComponent
} from "./pages/cadastros-iniciais/tipo-despesa-crud-component/tipo.despesa.crud.component";
import {
  CadastroFuncionarioCrudComponent
} from "./pages/cadastro-pessoas/cadastro-funcionario-crud-component/cadastro.funcionario.crud.component";
import {
  CadastroFornecedorCrudComponent
} from "./pages/cadastro-pessoas/cadastro-fornecedor-crud-component/cadastro.fornecedor.crud.component";
import {
  MovimentoFinanceiroCrudComponent
} from "./pages/Movimentos/movimento-financeiro-crud-component/movimento.financeiro.crud.component";

const routes: Routes = [
  {
    path: 'tasks',
    component: TasksComponent,
    canActivate: [ AuthGuardService ]
  },
  {
    path: 'profile',
    component: ProfileComponent,
    canActivate: [ AuthGuardService ]
  },
  {
    path: 'home',
    component: HomeComponent,
    canActivate: [ AuthGuardService ]
  },
  {
    path: 'login-form',
    component: LoginFormComponent,
    canActivate: [ AuthGuardService ]
  },
  {
    path: 'reset-password',
    component: ResetPasswordFormComponent,
    canActivate: [ AuthGuardService ]
  },
  {
    path: 'create-account',
    component: CreateAccountFormComponent,
    canActivate: [ AuthGuardService ]
  },
  {
    path: 'change-password/:recoveryCode',
    component: ChangePasswordFormComponent,
    canActivate: [ AuthGuardService ]
  },
/** INICIANDO ROTAS */

    /** RECEITA */
  {path: 'cadastro-receita', component: TipoReceitaCrudComponent, canActivate: [ AuthGuardService ]},
  {path: 'cadastro-receita/create', component: TipoReceitaCrudComponent, canActivate: [ AuthGuardService ]},
  {path: 'cadastro-receita/edit/:id', component: TipoReceitaCrudComponent, canActivate: [ AuthGuardService ]},

    /** DESPESA */
  {path: 'cadastro-despesa',component: TipoDespesaCrudComponent, canActivate: [ AuthGuardService ]},
  {path: 'cadastro-despesa/create', component: TipoDespesaCrudComponent, canActivate: [ AuthGuardService ]},
  {path: 'cadastro-despesa/edit/:id', component: TipoDespesaCrudComponent, canActivate: [ AuthGuardService ]},



  {
    path: 'cadastro-funcionario',
    component: CadastroFuncionarioCrudComponent,
    canActivate: [ AuthGuardService ]
  },
  {
    path: 'cadastro-fornecedor',
    component: CadastroFornecedorCrudComponent,
    canActivate: [ AuthGuardService ]
  },
  {
    path: 'movimentos-financeiros',
    component: MovimentoFinanceiroCrudComponent,
    canActivate: [ AuthGuardService ]
  },

  {
    path: '**',
    redirectTo: 'home'
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes, { useHash: true }), DxDataGridModule, DxFormModule],
  providers: [AuthGuardService],
  exports: [RouterModule],
  declarations: [
    HomeComponent,
    ProfileComponent,
    TasksComponent
  ]
})
export class AppRoutingModule { }
