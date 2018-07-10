import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ChartModule } from 'primeng/chart';
import { DropdownModule } from 'primeng/dropdown';
import { PanelModule } from 'primeng/panel';
import { TableModule } from 'primeng/table';
import { AppComponent } from './app.component';
import { TradeService } from './service/trade.service';
import { FormsModule } from '@angular/forms';




@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    PanelModule,
    TableModule,
    HttpClientModule,
    ChartModule,
    DropdownModule,
    FormsModule
  ],
  providers: [
    TradeService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
