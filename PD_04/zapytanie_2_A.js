// 2. Łączną ilość środków pozostałych na kartach kredytowych osób w bazie, w podziale na waluty

db.people.aggregate([{$unwind: '$credit'}]).forEach( function (x) { x.credit.balance = parseInt(x.credit.balance); db.people.save(x);});

printjson(db.people.aggregate([
  {$project: { credit: 1 } },
  { $unwind: '$credit' },
  { $group: { _id: '$credit.currency',
  total_balance: { $sum: '$credit.balance' } 
    } } ] ).toArray());
