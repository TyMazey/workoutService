package com.workoutService.Controllers;

import com.workoutService.Dao.WorkoutDao;
import com.workoutService.POJO.NewWorkout;
import com.workoutService.Entities.Workout;
import com.workoutService.Service.WorkoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;

@RestController
@RequestMapping("/api/v1")
public class WorkoutsController {

    @Autowired
    private WorkoutService workoutService;
    private WorkoutDao workoutDao;

    @GetMapping("/workouts")
    public Collection<Workout> index(){
        return workoutService.index();
    }

    @PostMapping("/workouts")
    public Workout create(@RequestBody NewWorkout workout) { return workoutService.create(workout); }

    @GetMapping("/workouts/{id}")
    public Object getWorkOutById(@PathVariable(name= "id") Long id) {
        return workoutService.show(id);
    }

    @GetMapping("/workoutsByTag")
    public Collection<Workout> getWorkoutByTags(@RequestParam(name= "tags") ArrayList tags) {
        Long length = Long.valueOf(tags.size());
        return workoutService.workoutByTags(tags, length);
    }

}
