 #include "WiFi.h"

const char* ssid = "YourSSID";
const char* password =  "YourPassword"; 
int led = 26;                // the pin that the LED is atteched to
int sensor = 27;              // the pin that the sensor is atteched to
int state = LOW;             // by default, no motion detected
int val = 0;                 // variable to store the sensor status (value)

void setup() {
  Serial.begin(115200);        // initialize serial
  WiFi.begin(ssid, password);
 
  while (WiFi.status() != WL_CONNECTED) {
    delay(500);
    Serial.println("Connecting to WiFi..");
  }
 
  Serial.println("Connected to the WiFi network");
  pinMode(led, OUTPUT);      // initalize LED as an output
  pinMode(sensor, INPUT);    // initialize sensor as an input
 
}

void loop(){
  val = digitalRead(sensor);   // read sensor value
  if (val == HIGH) {           // check if the sensor is HIGH
    digitalWrite(led, HIGH); 
    Serial.println("Motion Detected");// turn LED ON
       delay(50);             // delay 100 milliseconds
  } 
   val = digitalRead(sensor);   // read sensor value
  if (val == LOW){
     Serial.println("NO motion Detected");
     digitalWrite(led, LOW); 
  delay(50);
    
  }
  
}
