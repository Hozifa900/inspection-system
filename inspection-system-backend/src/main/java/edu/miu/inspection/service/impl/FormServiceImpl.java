package edu.miu.inspection.service.impl;

import edu.miu.inspection.model.Form;
import edu.miu.inspection.model.HotelForm;
import edu.miu.inspection.model.Task;
import edu.miu.inspection.model.enums.FormType;
import edu.miu.inspection.repository.FormRepository;
import edu.miu.inspection.repository.HotelFormRepository;
import edu.miu.inspection.service.FormService;
import edu.miu.inspection.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;

@Service
public class FormServiceImpl implements FormService {

    @Autowired
    private FormRepository formRepository;
    @Autowired
    private HotelFormRepository hotelFormRepository;
    @Autowired
    private TaskService taskService;

    @Override
    public Form findById(Long id) {
        return this.hotelFormRepository.getById(id);
    }

    @Override
    public Form createForm(HashMap<String, Object> record) {

        String formType = (String) record.get("formType");
        Long taskId = Long.valueOf(record.get("taskId").toString());
        Task task = this.taskService.findById(taskId);
        Form form = null;

        if (FormType.HOTEL.getValue().equals(formType)) {
            form = this.saveHotelForm(record);
        } else {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server Error");
        }

        task.setForm(form);
        taskService.save(task);
        return form;

    }

    private Form saveHotelForm(HashMap<String, Object> record) {
        HotelForm form = new HotelForm();
        form.setHotelName            ((String)  record.get("hotelName"              ));
        form.setNumberOfRooms        ((Integer) record.get("numberOfEmployees"      ));
        form.setNumberOfEmployees    ((Integer) record.get("numberOfEmployees"      ));
        form.setCleanlinessScore     ((Integer) record.get("cleanlinessScore"       ));
        form.setFireSafetyCompliance ((Integer) record.get("fireSafetyCompliance"   ));
        form.setRoomServiceQuality   ((Integer) record.get("roomServiceQuality"     ));
        form = this.hotelFormRepository.save(form);
        return form;
    }

}
