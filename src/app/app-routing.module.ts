import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { LoginComponent } from './login/login.component';
import { RegistrationComponent } from './registration/registration.component';
import { DashboardComponent } from './dashboard/dashboard.component';

import { TransactionsComponent } from './transactions/transactions.component';
import { AccountstatementComponent } from './accountstatement/accountstatement.component';
import { FundtransferComponent } from './fundtransfer/fundtransfer.component';
import { OverdraftComponent } from './overdraft/overdraft.component';
import { ProfileComponent } from './profile/profile.component';
import { AddbalanceComponent } from './addbalance/addbalance.component';



const routes: Routes = [
  //{path:'',component: LoginComponent},
{path:'login',component: LoginComponent},
{path:'registration',component: RegistrationComponent},
{path:'dashboard',component: DashboardComponent},
{path:'profile',component: ProfileComponent},
{path:'overdraft',component: OverdraftComponent},
{path:'fundtransfer',component: FundtransferComponent},
{path:'accountstatement',component: AccountstatementComponent},
{path:'transactions',component: TransactionsComponent},
{path : 'addbalance',component : AddbalanceComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
