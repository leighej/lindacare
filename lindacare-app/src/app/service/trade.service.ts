import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

import { Trade } from '../domain/trade';
import { Observable } from 'rxjs';



@Injectable()
export class TradeService {


    constructor(private http: HttpClient) {}

    /**
     * Get all the trades
     */
    getTrades(): Observable<Trade[]> {
        return this.http.get<Trade[]>('/trades');
    }

    /**
     * Get all the trades by a user
     */
    getTradesByUserId(userId: String): Observable<Trade[]> {
      return this.http.get<Trade[]>('/trades/' + userId);
  }

    /**
     * Get the list of users that have traded
     */
    getUsers(): Observable<String[]> {
      return this.http.get<String[]>('/users');
    }
}
