// 9.	Dodaj do wszystkich osób o imieniu Antonio własność „hobby” o wartości „pingpong”; 
printjson(db.people.update({first_name: 'Antonio' },
{$set: { hobby: 'pingpong' }}, { multi: true }));