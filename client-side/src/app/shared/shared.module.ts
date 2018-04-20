import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { HTTP_INTERCEPTORS } from '@angular/common/http';
import { TokenInterceptor } from './interceptors/http/TokenInterceptor';
import { DropDownDirective } from './directives/dropdown.directive';



@NgModule({
  imports: [
    CommonModule
  ],
  declarations: [DropDownDirective],
  exports: [
    DropDownDirective
  ],
  providers: []

})
export class SharedModule { }
