// 5. Średnia i łączna ilość środków na kartach kredytowych kobiet narodowości polskiej w podziale na waluty

printjson(db.people.aggregate( [
  { $match: { nationality: 'Poland', sex: 'Female' } },
  { $unwind:'$credit'},
  { $group: { _id: '$credit.currency',
  total_on_cards: { $sum: '$credit.balance' },
  avg_on_cards: { $avg: '$credit.balance'}
    } } ] ).toArray());
