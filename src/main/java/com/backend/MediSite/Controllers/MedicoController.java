    package com.backend.MediSite.Controllers;

    import com.backend.MediSite.Models.MedicoModel;
    import com.backend.MediSite.Services.MedicoService;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.web.bind.annotation.*;

    import java.util.ArrayList;
    import java.util.Optional;

    @RestController
    @RequestMapping("/Medico")
    public class MedicoController {

        @Autowired
        private MedicoService medicoService;


        @PostMapping("/Create")
        public MedicoModel Create(@RequestBody MedicoModel Medico){
            return this.medicoService.Create(Medico);
        }

        @GetMapping("/Read")
        public ArrayList<MedicoModel> Read(){
            return this.medicoService.Read();
        }

        @GetMapping("/MedicoById/{IdMedico}")
        public Optional<MedicoModel> MedicoById(@PathVariable("IdMedico") Long IdMedico){
            return this.medicoService.MedicoById(IdMedico);
        }


        @PutMapping("/Update/{IdMedico}")
        public MedicoModel Update(@RequestBody MedicoModel request, @PathVariable Long IdMedico){
            return this.medicoService.Update(request, IdMedico);
        }

        @DeleteMapping("/Delete/{IdMedico}")
        public String Delete(@PathVariable("IdMedico") Long IdMedico){
            boolean ok = this.medicoService.Delete(IdMedico);
            if(ok){
                return "Medico con Id " + IdMedico + " eliminado correctamente";
            }
            else{
                return "No se pudo eliminar el medico con Id " + IdMedico;
            }
        }


    }
