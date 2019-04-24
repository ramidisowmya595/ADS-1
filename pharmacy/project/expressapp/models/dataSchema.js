var mongoose=require('mongoose');

var countrySchema=mongoose.Schema({
    mname:{type:String},
    price:{type:String},
    quantity:{type:String},
    mfgdate:{type:String},
    expdate:{type:String}
    
});

module.exports=mongoose.model('country',countrySchema);