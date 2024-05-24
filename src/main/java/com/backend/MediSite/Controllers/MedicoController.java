    package com.backend.MediSite.Controllers;

    import com.backend.MediSite.Models.CiudadModel;
    import com.backend.MediSite.Models.MedicoModel;
    import com.backend.MediSite.Models.EspecialidadModel;
    import com.backend.MediSite.Services.EspecialidadService;
    import com.backend.MediSite.Services.MedicoService;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.format.annotation.DateTimeFormat;
    import org.springframework.web.bind.annotation.*;

    import java.time.LocalDateTime;
    import java.time.format.DateTimeFormatter;
    import java.util.ArrayList;
    import java.util.List;
    import java.util.Optional;

    @RestController
    @RequestMapping("/Medico")
    public class MedicoController {

        @Autowired
        private MedicoService medicoService;

        @Autowired
        private EspecialidadService especialidadService;


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

        @GetMapping("/ReadIdEspecialidad/{IdEspecialidad}")
        public List<MedicoModel> ReadByIdEspecialidad(@PathVariable Long IdEspecialidad) {
            EspecialidadModel especialidad = new EspecialidadModel();
            especialidad.setIdEspecialidad(IdEspecialidad);
            return medicoService.ReadByIdEspecialidad(especialidad);
        }

        @GetMapping("/ReadIdCiudad/{IdCiudad}")
        public List<MedicoModel> ReadByIdCiudad(@PathVariable Long IdCiudad) {
            CiudadModel ciudad = new CiudadModel();
            ciudad.setIdCiudad(IdCiudad);
            return medicoService.ReadByIdCiudad(ciudad);
        }



        @GetMapping("/ReadByCiudadEspecialidad")
        public List<MedicoModel> ReadCiudadEspecialidad(
                @RequestParam(required = false) Long idEspecialidad,
                @RequestParam(required = false) Long idCiudad) {

            EspecialidadModel especialidad = null;
            if (idEspecialidad != null) {
                especialidad = new EspecialidadModel();
                especialidad.setIdEspecialidad(idEspecialidad);
            }

            CiudadModel ciudad = null;
            if (idCiudad != null) {
                ciudad = new CiudadModel();
                ciudad.setIdCiudad(idCiudad);
            }

            return medicoService.ReadCiudadEspecialidad(especialidad, ciudad);
        }



        @GetMapping("/sin-citas")
        public List<MedicoModel> obtenerMedicosSinCitas(
                @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fechaHoraInicio,
                @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fechaHoraFin) {
            return medicoService.obtenerMedicosSinCitas(fechaHoraInicio, fechaHoraFin);
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
