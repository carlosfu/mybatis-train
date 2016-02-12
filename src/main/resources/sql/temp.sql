1. select * from player p, club c where p.club_id=c.id and p.id=#{id};

2. 
select * from player where id=#{id}
select * from club where id=#{id}
