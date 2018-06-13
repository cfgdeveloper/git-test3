

/* 1. Quantitat de registres de la taula vols */
select count(*) from flights;


/* 2. Retard promig de sortida i arribada segons l'aeroport origen */
select avg(DepDelay), avg(ArrDelay), Origin from flights
group by Origin;


/* 3. Retard promig d'arribada dels vols, per mesos i segons l'aeroport origen */
select Origin, colYear, colMonth, avg(ArrDelay) from flights
group by Origin, colYear, colMonth;


/* 4. Mateixa consulta que l'anterior, però mostrant el nom de la ciutat en comptes del codi */
select City, colYear, colMonth, avg(ArrDelay) from flights, usairports
where origin = iata
group by Origin, colYear, colMonth;


/* 5. Companyies amb vols mes cancelats (en ordre decreixent) */
select Description, count(cancelled) from flights, carriers
where UniqueCarrier = CarrierCode
and cancelled = 1
group by UniqueCarrier
order by 2 desc;


/* 6. Identificador dels 10 vols que més kilòmetres han fet */
select FlightNum, sum(Distance) from flights
group by FlightNum
order by 2 desc
limit 10;


/* 7. Companyies amb el seu retard promig (nomes les que els seus vols
arriben amb un retard promig major a 10 minuts) */
select Description, FlightNum, avg(ArrDelay) from flights, carriers
where UniqueCarrier = CarrierCode
group by CarrierCode, FlightNum
having avg(ArrDelay) > 10
order by 3 desc;

/*
select * from flights;
select * from carriers;
select * from usairports;
*/

