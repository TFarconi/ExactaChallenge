import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { GastoListComponent } from './components/gasto/gasto-list/gasto-list.component';
import { GastoNewComponent } from './components/gasto/gasto-new/gasto-new.component';
import { GastoViewComponent } from './components/gasto/gasto-view/gasto-view.component';

const routes: Routes = [
  {
    path: "",
    component: GastoListComponent
  },
  {
    path: "gasto/new",
    component: GastoNewComponent
  },
  {
    path: "gasto/view/:id",
    component: GastoViewComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
