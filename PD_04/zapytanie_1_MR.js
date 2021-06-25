// 1. Średnią wagę i wzrost osób w bazie z podziałem na płeć (tzn. osobno mężczyzn, osobno kobiet)

db.people.mapReduce(
    function() 
    { emit(this.sex, { 
        'height': parseFloat(this.height), 
        'weight': parseFloat(this.weight), 
        'count': 1} ) },
        
        function(key, values) 
        { return { 
            'height': Array.sum(values.map(e => e['height'])), 
            'weight': Array.sum(values.map(e => e['weight'])), 
            'count': Array.sum(values.map(e => e['count'])) 
        } },
    
    { finalize: function(key, value) {
            return { 
                'avg_height': (value.height / value.count),
                'avg_weight': (value.weight / value.count) } },
        
        out: 'zapytanie_1_MR'
    } );

printjson(db.zapytanie_1_MR.find().toArray());
