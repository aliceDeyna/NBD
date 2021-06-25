// 4. Średnie, minimalne i maksymalne BMI (waga/wzrost^2) dla osób w bazie, w podziale na narodowości; 

printjson(db.people.aggregate( [
  { $addFields: { bmi: { $divide: [ '$weight',
  { $multiply: [ { $divide: ['$height', 100] },
  { $divide: ['$height', 100] } 
  ] } ] } } },
  { $group: { _id: '$nationality',
  avg_BMI: { $avg: '$bmi' },
  max_BMI: { $max: '$bmi' },
  min_BMI: { $min: '$bmi' } 
  } } ] ).toArray());
