// 3. Listę unikalnych zawodów

var map = function() 
{ emit(this.job, null); };

var reduce = function (key, values) 
{ return 1};

db.people.mapReduce(map, reduce, {out: "unique_jobs_list"});

printjson(db.unique_jobs_list.find().toArray());