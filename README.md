Ocean probe accepts two commands 
1. localhost:8080/navigate/move?forward=true
   Request parameter forward is boolean(default to true)
   Response would be co-ordiantes of the new position the probe is moved to.
3. localhost:8080/navigate/turn?left=true
   Request parameter is left. If true turn to left. if false turn right.
   Response would be the new Direction probe is facing.


