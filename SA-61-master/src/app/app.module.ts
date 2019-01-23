import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { MatButtonModule, MatCardModule, MatInputModule, MatListModule, MatToolbarModule } from '@angular/material';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FormsModule } from '@angular/forms';
import { RouterModule, Routes } from '@angular/router';
import { MainComponent } from './main/main.component';
import {MatTableModule} from '@angular/material/table';
import { Delivery1Component } from './delivery1/delivery1.component';
import { Delivery2Component } from './delivery2/delivery2.component';
import { Delivery3Component } from './delivery3/delivery3.component';
import { ShowinfoComponent } from './showinfo/showinfo.component';
import {MatSelectModule} from '@angular/material/select';

const appRoutes: Routes = [
{ path: '',  redirectTo: '/transport', pathMatch: 'full' },
{ path: 'main', component: MainComponent },
{ path: 'transport', component: Delivery1Component },
{ path: 'transport_next/:province', component: Delivery2Component },
{ path: 'transport_final', component: Delivery3Component },
{ path: 'infomation_final', component: ShowinfoComponent },
];

@NgModule({
  declarations: [
    AppComponent,
    MainComponent,
    Delivery1Component,
    Delivery2Component,
    Delivery3Component,
    ShowinfoComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatButtonModule,
    MatCardModule,
    MatInputModule,
    MatListModule,
    MatToolbarModule,
    FormsModule,
    MatTableModule,
    MatSelectModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
