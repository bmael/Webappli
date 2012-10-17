class ItineraryStats
!!!142722.java!!!	ItineraryStats(in id : int, in time : int, in date : String, in hour : String)
        this.id = id;
        this.time = time;
        this.dateD = date;
        this.hourH = hour;         
!!!142850.java!!!	getId() : int
        return id;
!!!142978.java!!!	getTime() : int
        return time;
!!!143106.java!!!	getHour() : String
        return hourH;
!!!143234.java!!!	getDate() : String
        return dateD;
!!!143362.java!!!	setDate(in date : String) : void
        this.dateD = date;
!!!143490.java!!!	reverseDate(in date : String) : String
        String modifiedDate;
        modifiedDate = date.substring(6, date.length()) + date.substring(2, 6) + date.substring(0, 2);
        return modifiedDate;
!!!143618.java!!!	toString() : String
        
        String res = "";
        
        res+= "----------------------------\n";
        res+= "id : " + id + "\n";
        res+= "time : " + time + "\n";
        res+= "dateD : " + dateD + "\n";
        res+= "hourH : " + hourH + "\n";
        
        return res;
!!!143746.java!!!	compareTo(inout o : ItineraryStats) : int
        SimpleDateFormat simpledate = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        try {
            Date d1 = simpledate.parse(dateD + " " + hourH);
            Date d2 = simpledate.parse(o.dateD + " " + o.hourH);
            return d1.compareTo(d2);

        } catch (ParseException ex) {
            Logger.getLogger(ItineraryStats.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
        
