NitroCabBooking
===============
Help Sapient design and code a Cab booking system for one of its client NitroCabs. The system is required
to be a computer-based-booking system that receives booking requests and books the cabs corresponding
to requests.
The city in which NitroCabs operates in is divided into 100 sectors each having 6 digits area codes ranging
from 100001 to 100100. The distance between two adjacent sectors is 2 km
I.e. distance between area 100008 and 100009 is 2 km, similarly between 100008 and 100015 is 14 km.
Time taken by a cab to travel 1 km is 2 minutes. The company incurs a cost of Rs. 5/ km but charges a fare
of Rs.10/ km.
The system specifications for booking are as follows:
The system takes a batch of booking requests and finds suitable cabs for serving the requests. It can be
assumed that requests can only have pickup time on the same day. A request comprises of unique
request id, pick up area code, and drop area code and pickup time.
System should take the requests and book the cabs that meet the following criteria:
• The cab booked should reach the pickup point 15 minutes early.
• The cab earns a profit margin of at least 20%.
In case system finds multiple cabs satisfying above criteria for a request then system books the one in
which profit is maximum.
