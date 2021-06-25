// 4. Średnie, minimalne i maksymalne BMI (waga/wzrost^2) dla osób w bazie, w podziale na narodowości


var map = function () 
{ emit(this.nationality, { weight: this.weight, height: this.height } );};


var reduce = function (key, values) {
    let total = 0;
    let max = 0;
    let min = Infinity;
    
    values.forEach(calculate => {
      const convert_height = calculate.height / 100;
      const bmi = calculate.weight / (convert_height * convert_height);

      total += bmi;
      if (bmi > max) max = bmi;
      if (bmi < min) min = bmi;
    } );

    return { avg: total / values.length, max, min };
  };

db.people.mapReduce(map, reduce, {out: "zapytanie_4_MR"});

printjson(db.zapytanie_4_MR.find().toArray());