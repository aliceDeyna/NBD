// 6.	Dodaj siebie do bazy, zgodnie z formatem danych użytych dla innych osób (dane dotyczące karty kredytowej, adresu zamieszkania i wagi mogą być fikcyjne); 
printjson(db.people.insert({
  sex: 'Female',
  first_name: 'Alisa',
  last_name: 'Deyna',
  job: 'Data analyst',
  email: 'alisa.deyna@gmail.com',
  location: {
    city: 'Warsaw',
    address: { streetname: 'Bruna', streetnumber: '9' }
  },
  description: "ac leo pellentesque ultrices mattis odio donec vitae nisi nam ultrices libero non mattis pulvinar",
  height: 175,
  weight: 52,
  birth_date: '1991-01-28T10:00:00Z',
  nationality: 'Canada',
  credit: [
    {
      type: 'mastercard',
      number: '4017957170327',
      currency: 'PLN',
      balance: '20000'
    }
  ]
}))