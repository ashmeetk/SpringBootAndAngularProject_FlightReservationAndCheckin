import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { StartcheckinComponent } from './components/startcheckin/startcheckin.component';
import { ConfirmComponent } from './components/confirm/confirm.component';
import { CheckinComponent } from './components/checkin/checkin.component';

const routes: Routes = [
  {
    path: '',
    redirectTo: '',
    pathMatch: 'full'
  },
  {
    path: 'startCheckIn',
    component: StartcheckinComponent
  },
  {
    path: 'checkIn',
    component: CheckinComponent
  },
  {
    path: 'confirm',
    component: ConfirmComponent
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
