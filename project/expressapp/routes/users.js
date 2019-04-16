var express = require('express');
var router = express.Router();
var User=require('../models/user');
var Country=require('../models/dataSchema');

var passport=require('passport');
/* GET users listing. */
//router.get('/', function(req, res, next) {
  //res.send('respond with a resource');
//});
router.post('/register',function(req,res,next){
  addToDB(req,res);
});

async function addToDB(req,res){
  var user =new User({
    email:req.body.email,
    username:req.body.username,
    password:User.hashPassword(req.body.password),
    creation_dat:Date.now()
  });
  try{
    doc=await user.save();
    return res.status(201).json(doc);

  }
  catch(err)
  {
    return res.status(501).json(err);
  }
}
router.post('/login',function(req,res,next){
  
    passport.authenticate('local', function(err, user, info) {
      if (err) { return res.status(501).json(err); }
      if (!user) { return res.status(501).json(info); }
      req.logIn(user, function(err) {
        if (err) { return res.status(501).json(err) ; }
        return res.status(200).json({message:'Login Success'});
      });
    })(req, res, next);
  });

  router.post('/create',(req,res,next) => {
    var newCountry=new Country({
      mname:req.body.mname,
      price:req.body.price,
      quantity:req.body.quantity,
      mfgdate:req.body.mfgdate,
      expdate:req.body.expdate
  
  });
  newCountry.save((err,country)=>{
    if(err)
    {
        res.status(500).json({errmsg:err});
        res.status(200).json({msg:country});
  
    }
  });
    //res.status(200).json({msg:'post request woerking'});
  res.json(newCountry);
});

router.get('/read',(req,res,next) => {
  Country.find({},(err,countries)=>{
    if(err)
      res.status(500).json({errmsg:err});
    res.status(200).json({msg:countries});  

});
   // res.status(200).json({msg:'get request woerking'});
});
    
router.put('/update',(req,res,next) => {
  Country.findById(req.body._id,(err,country)=>{
    if(err)
        res.status(500).json({errmsg:err});
    country.mname=req.body.mname;
    country.price=req.body.price;
    country.quantity=req.body.quantity;
    country.mfgdate=req.body.mfgdate;
    country.expdate=req.body.expdate;
    country.save((err,country)=>{
        if(err)
            res.status(500).json({errmsg:err});
        res.status(200).json({msg:country});

    });
   });
  //res.status(200).json({msg:'put request woerking'});

    });
router.delete('/delete/:id',(req,res,next) => {
  Country.findOneAndDelete({_id:req.params.id},(err,country)=>{
    if(err)
      res.status(500).json({errmsg:err});
    res.status(200).json({msg:country});

});
  //res.status(200).json({msg:'delete request woerking'});

});


module.exports = router;
