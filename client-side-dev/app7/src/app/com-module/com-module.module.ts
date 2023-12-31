import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ComModuleRoutingModule } from './com-module-routing.module';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { SidebarComponent } from './sidebar/sidebar.component';


@NgModule({
  declarations: [
    HeaderComponent,
    FooterComponent,
    SidebarComponent
  ],
  imports: [
    CommonModule,
    ComModuleRoutingModule
  ],
  exports:[
     HeaderComponent,
     FooterComponent,
     SidebarComponent
  ]
})
export class ComModuleModule { }
