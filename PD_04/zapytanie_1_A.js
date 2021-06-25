// 1. Średnią wagę i wzrost osób w bazie z podziałem na płeć (tzn. osobno mężczyzn, osobno kobiet)

db.people.find().forEach( function (x) { x.height = parseInt(x.height); db.people.save(x);});

db.people.find().forEach( function (x) { x.weight = parseInt(x.weight); db.people.save(x);});

printjson(db.people.aggregate( [
  {$group: { _id: '$sex',
  total_weight: { $sum: '$weight' },
  total_height: { $sum: '$height' },
  total: { $sum: 1 } } },
  {$project: { total_weight: 1,
  total_height: 1,
  total: 1,
  avg_weight: { $divide: ['$total_weight', '$total'] },
  avg_height: { $divide: ['$total_height', '$total'] }
    } } ] ).toArray());
