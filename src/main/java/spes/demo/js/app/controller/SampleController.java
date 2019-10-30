package spes.demo.js.app.controller;

import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.io.ParseException;
import org.locationtech.jts.io.WKTReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import spes.demo.js.app.entity.Sample;
import spes.demo.js.app.repo.SampleRepo;

@Controller
@RequestMapping("/")
public class SampleController {
    @Autowired
    private SampleRepo repo;

    @ResponseBody
    @RequestMapping("list")
    public String list(){
        var it = repo.findAll();
        StringBuilder sb = new StringBuilder();
        it.forEach(s->{
            sb.append(s.getId() + " ");
        });
        return sb.toString();
    }
    @ResponseBody
    @RequestMapping("geom/{id}")
    public String geom(@PathVariable Long id){
        Sample s = repo.findOne(id);
        if(s == null) return "empty.";
        return s.getGeom().toString();
    }

    @ResponseBody
    @RequestMapping("add/{x}/{y}")
    public String add(@PathVariable Double x, @PathVariable Double y){
        Sample s = new Sample();
        try {
            Geometry g = new WKTReader().read("POINT (" + x + " " + y + ")");
            s.setGeom(g);
        } catch (ParseException e) {
            return "invalid format";
        }
        repo.save(s);
        return "ok";
    }
}
