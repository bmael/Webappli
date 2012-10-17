class PMV
!!!143874.java!!!	PMV(in id : int, in sens : String, inout indic_temps : boolean, in longitude : float, in latitude : float)
        this.id = id;
        this.sens = sens;
        this.indic_temps = indic_temps;
        this.longitude = longitude;
        this.latitude = latitude;
!!!144002.java!!!	getId() : int
        return id;
!!!144130.java!!!	getSens() : String
        return sens;
!!!144258.java!!!	isIndic_temps() : boolean
        return indic_temps;
!!!144386.java!!!	getLongitude() : float
        return longitude;
!!!144514.java!!!	getLatitude() : float
        return latitude;
!!!144642.java!!!	getItineraries() : Itinerary
        return itineraries;
!!!144770.java!!!	setId(in id : int) : void
        this.id = id;
!!!144898.java!!!	setSens(in sens : String) : void
        this.sens = sens;
!!!145026.java!!!	setIndic_temps(inout indic_temps : boolean) : void
        this.indic_temps = indic_temps;
!!!145154.java!!!	setLongitude(in longitude : float) : void
        this.longitude = longitude;
!!!145282.java!!!	setLatitude(in latitude : float) : void
        this.latitude = latitude;
!!!145410.java!!!	setItineraries(inout itineraries : List<Itinerary>) : void
        this.itineraries = itineraries;
!!!145538.java!!!	toString() : String
        
        String res = "Numéro : " + this.id;
        res += " | Sens : " + this.sens;
        res += " | Indique temps parcours : " + this.indic_temps;
        
        return res;    
