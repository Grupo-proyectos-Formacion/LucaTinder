import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class LoggedService {
  public isUserLoggedIn: boolean = false;
  constructor() { }

  setLoginStatus(isLoggedIn){
    this.isUserLoggedIn = isLoggedIn;
}

getLoginStatus(){
    return this.isUserLoggedIn;
} 
}
