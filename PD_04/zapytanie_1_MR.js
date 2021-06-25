// 1. Średnią wagę i wzrost osób w bazie z podziałem na płeć (tzn. osobno mężczyzn, osobno kobiet)

db.people.mapReduce(
  function () {
    emit(this.sex, { weight: this.weight, height: this.height 
      } ); },

  function (key, values) {
    let total_weight = 0;
    let total_height = 0;

    values.forEach(element => {
      total_weight += element.weight;
      total_height += element.height;
    } );

    return {
      avg_weight: total_weight / values.length,
      avg_height: total_height / values.length };
  },
  { out: 'zapytanie_1_MR' }
);

printjson(db.zapytanie_1_MR.find().toArray());
