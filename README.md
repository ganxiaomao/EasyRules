# EasyRules
Library to create Rules and Action easily
Now we have an easy way to create Rules and Actions. 
Its easy to process any data streams or set of records; apply rules as easy as If <Expression> Then <Actions> end.
The only target for you is to parse your data and convert them in to the Record format. Record is nothing but key value pair.
You can create rules as simple as English language. 
And actions can be easily created by very less efforts. Few simple actions are inbuilt like log to console or log to file.
I am working on creating few more generally used actions like log to database table etc.

Example:
Say you have multiple thermostats sensing temperature at different rooms in a building. And sending the temperature as data stream.
You will have to write parser to parse those data packets and create a record object from that.
e.g. data packet looks like <Temperature,Location,Timestamp> then, parse that as delimited fields and convert it to key value pair as:
e.g. record is 25,LAB-1,2015:03:19:14:30:05
Then the key value pair for record should look like:
{ 
Temperature:25
Location:LAB-1
Timestamp:2015:03:19:14:30:05
}
Once the record is created, next step will be to create rules.
Syntax of the rules is:
If <Expression> Then
<Actions>
End
e.g. 
-------------------------------------------------------------------------------------------
If Temperature < 10 Then
log("Temperature is less than 10! Its too cool now! Its ${Temperature} now!!!")
filelog("Alert Temperature in the file! Its ${Temperature}!!!")
End

If Temperature>30 && Location == "LAB-1" Then 
log("Its hot in the ${Location}! Is there anything wrong at ${Location} Temperature is ${Temperature} now!!!")
End

-------------------------------------------------------------------------------------------


