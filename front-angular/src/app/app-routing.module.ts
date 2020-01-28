import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {Home} from './home/home.component';
import {FixtureRapportComponent} from './fixture-rapport/fixture-rapport.component';


const routes: Routes = [
  {path:'',component: Home},
  {path:'fixture-rapport', component:FixtureRapportComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
