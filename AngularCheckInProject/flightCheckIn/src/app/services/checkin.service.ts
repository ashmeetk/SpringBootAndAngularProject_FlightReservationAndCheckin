import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class CheckinService {

  getReservationUrl = "http://localhost:8080/flightreservation/reservations/";
  putReservationUrl = "http://localhost:8080/flightreservation/reservations";
  reservationData:any;

  constructor(private _httpClient:HttpClient) { }

  public getReservation(id: Number):any{
    return this._httpClient.get(this.getReservationUrl+id);
  }

  public checkIn(checkInRequest: any):any{
    return this._httpClient.put(this.putReservationUrl, checkInRequest);
  }
}
