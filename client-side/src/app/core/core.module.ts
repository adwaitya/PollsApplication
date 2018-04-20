import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { ReactiveFormsModule } from '@angular/forms';

import { LoginComponent } from './components/login/login.component';
import { RegisterComponent } from './components/register/register.component';
import { ProfileComponent } from './components/profile/profile.component';
import { CoreRoutingModule } from './core-routing.module';
import { AuthService } from './services/auth.service';
import { NotAuthGuard } from './guards/notAuth.guard';
import { AuthGuard } from './guards/auth.guard';
import { HeaderComponent } from './components/header/header.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
@NgModule({
  imports: [
    CommonModule,
    CoreRoutingModule,
    ReactiveFormsModule,
    NgbModule.forRoot()
  ],
  declarations: [LoginComponent, RegisterComponent, ProfileComponent, HeaderComponent],
  exports: [
    RouterModule, HeaderComponent
  ],
  providers: [
    AuthService, AuthGuard, NotAuthGuard
  ]
})
export class CoreModule { }
