# lindacare
Lindacare test


Url for application frontend: http://leigh.familyds.com:8080/
  
Rest endpoints  
  
To post a trade of this format 
{"userId": "134256", "currencyFrom": "EUR", "currencyTo": "GBP", "amountSell": 1000, "amountBuy": 747.10, "rate": 0.7471, "timePlaced" : "24-JAN-15 10:27:44", "originatingCountry"
: "FR"}  
  
use 
  
#Post
http://leigh.familyds.com:8080/trade  
It returns you a UUID as a response on success.  
  
Other rest services available:  

All are GET requests:  
http://leigh.familyds.com:8080/trades  - All the trades in the system  
http://leigh.familyds.com:8080/trade/{uuid} - The trade associated to the UUID  
http://leigh.familyds.com:8080/trades/{userId} - The list of trade(s) associated to that userId  
http://leigh.familyds.com:8080/users - The unique list of users that have trades  



**NOTE:**  It appears that the frontend does not work on IE11 (Windows 7).  I don't have time to find out why.  But it works fine in Chrome / Firefox / Edge


**Source**  
Folder lindacare-app holds the frontend Angular 6 application  
Folder src hold the java backend  (Using Spring boot)


