import { Component, OnInit } from '@angular/core';
import { TradeService } from './service/trade.service';
import { Trade } from './domain/trade';
import { User } from './domain/user';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'app';
  trades: Trade[];
  users: User[];
  selectedUser: String;
  cols: any[];
  data: any;


  constructor(private tradeService: TradeService) {
    // Columns for the table
    this.cols = [
      { field: 'userId', header: 'User ID' },
      { field: 'currencyFrom', header: 'Currency From' },
      { field: 'currencyTo', header: 'Currency To' },
      { field: 'amountBuy', header: 'Amount Bought' },
      { field: 'amountSell', header: 'Amount Sold' },
      { field: 'rate', header: 'Rate' },
      { field: 'timePlaced', header: 'Date' },
      { field: 'originatingCountry', header: 'Country of Origin' },

    ];

    this.users = [{ label: 'All', value: 'ALL'}];

  }
  ngOnInit() {
    this.getAllTrades();
    this.tradeService.getUsers().subscribe(users => {
      // console.log(users);
      for (const user of users) {
        this.users.push({label: user, value: user});
      }


    });
  }

  /**
   * User changed in the dropdown list
   */
  changeUser() {
    if (this.selectedUser === 'ALL') {
      this.getAllTrades();
    } else {
      this.getTradesByUser(this.selectedUser);
    }
  }
  /**
   * Get all the trades
   */
  private getAllTrades() {
    this.tradeService.getTrades().subscribe(trades => {
      // console.log(trades);
      this.trades = trades;
      this.processChartData();
    });
  }

  /**
   * Get all the trades by userid
   * @param userId - The user id of the trades you want
   */
  private getTradesByUser(userId: String) {
    this.tradeService.getTradesByUserId(userId).subscribe(trades => {
      // console.log(trades);
      this.trades = trades;
      this.processChartData();
    });
  }

  private processChartData() {
    const labels = [];
    const data = [];

    for (const trade of this.trades) {
      labels.push(trade.timePlaced);
      data.push(trade.amountSell);
    }
    this.data = {
      labels: labels,
      datasets: [
          {
              label: 'Trades',
              data: data,
              fill: false,
              borderColor: '#4bc0c0'
          }
      ]
    };

  }
}
