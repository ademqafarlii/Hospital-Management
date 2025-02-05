package org.adem.hospitalmanagement.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(AppointmentNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleAppointmentNotFoundException(AppointmentNotFoundException e,
                                                                 WebRequest webRequest){
        Map<String, String> errors = new HashMap<>();
        errors.put("message", e.getMessage());

        log.error("Appointment not found exception", e);
        ErrorResponse errorResponse = ErrorResponse.builder()
                .message(errors)
                .path(webRequest.getHeader("Content-Type"))
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .timestamp(LocalDate.now())
                .build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(errorResponse);
    }

    @ExceptionHandler(DepartmentNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleDepartmentNotFoundException(DepartmentNotFoundException e,
                                                                           WebRequest webRequest){
        Map<String, String> errors = new HashMap<>();
        errors.put("message", e.getMessage());

        log.error("Department not found exception", e);
        ErrorResponse errorResponse = ErrorResponse.builder()
                .message(errors)
                .path(webRequest.getHeader("Content-Type"))
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .timestamp(LocalDate.now())
                .build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(errorResponse);
    }

    @ExceptionHandler(DoctorNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleDoctorNotFoundException(DoctorNotFoundException e,
                                                                       WebRequest webRequest){
        Map<String, String> errors = new HashMap<>();
        errors.put("message", e.getMessage());

        log.error("Doctor not found exception", e);
        ErrorResponse errorResponse = ErrorResponse.builder()
                .message(errors)
                .path(webRequest.getHeader("Content-Type"))
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .timestamp(LocalDate.now())
                .build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(errorResponse);
    }

    @ExceptionHandler(MedicationNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleMedicationNotFoundException(MedicationNotFoundException e,
                                                                           WebRequest webRequest){
        Map<String, String> errors = new HashMap<>();
        errors.put("message", e.getMessage());

        log.error("Medication not found exception", e);
        ErrorResponse errorResponse = ErrorResponse.builder()
                .message(errors)
                .path(webRequest.getHeader("Content-Type"))
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .timestamp(LocalDate.now())
                .build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(errorResponse);
    }

    @ExceptionHandler(PatientNotFoundException.class)
    public ResponseEntity<ErrorResponse> handlePatientNotFoundException(PatientNotFoundException e,
                                                                        WebRequest webRequest){
        Map<String, String> errors = new HashMap<>();
        errors.put("message", e.getMessage());

        log.error("Patient not found exception", e);
        ErrorResponse errorResponse = ErrorResponse.builder()
                .message(errors)
                .path(webRequest.getHeader("Content-Type"))
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .timestamp(LocalDate.now())
                .build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(errorResponse);
    }

    @ExceptionHandler(StaffMemberNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleStaffMemberNotFoundException(StaffMemberNotFoundException e,
                                                                            WebRequest webRequest){
        Map<String, String> errors = new HashMap<>();
        errors.put("message", e.getMessage());

        log.error("Staff member not found exception", e);
        ErrorResponse errorResponse = ErrorResponse.builder()
                .message(errors)
                .path(webRequest.getHeader("Content-Type"))
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .timestamp(LocalDate.now())
                .build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(errorResponse);
    }

    @ExceptionHandler(IncorrectCredentialsException.class)
    public ResponseEntity<ErrorResponse> handleIncorrectCredentialsException(IncorrectCredentialsException e,
                                                                             WebRequest webRequest){
        Map<String, String> errors = new HashMap<>();
        errors.put("message", e.getMessage());

        log.error("Incorrect credentials", e);
        ErrorResponse errorResponse = ErrorResponse.builder()
                .message(errors)
                .path(webRequest.getHeader("Content-Type"))
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .timestamp(LocalDate.now())
                .build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(errorResponse);
    }

    @ExceptionHandler(PrescriptionNotFoundException.class)
    public ResponseEntity<ErrorResponse> handlePrescriptionNotFoundException(PrescriptionNotFoundException e,
                                                                             WebRequest webRequest){
        Map<String, String> errors = new HashMap<>();
        errors.put("message", e.getMessage());

        log.error("Prescription not found exception", e);
        ErrorResponse errorResponse = ErrorResponse.builder()
                .message(errors)
                .path(webRequest.getHeader("Content-Type"))
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .timestamp(LocalDate.now())
                .build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(errorResponse);
    }

    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleUsernameNotFoundException(UsernameNotFoundException e,
                                                                         WebRequest webRequest){
        Map<String, String> errors = new HashMap<>();
        errors.put("message", e.getMessage());

        log.error("Username not found exception", e);
        ErrorResponse errorResponse = ErrorResponse.builder()
                .message(errors)
                .path(webRequest.getHeader("Content-Type"))
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .timestamp(LocalDate.now())
                .build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(errorResponse);
    }

    @ExceptionHandler(RoleNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleRoleNotFoundException(RoleNotFoundException e,
                                                                     WebRequest webRequest){
        Map<String, String> errors = new HashMap<>();
        errors.put("message", e.getMessage());

        log.error("Role not found exception", e);
        ErrorResponse errorResponse = ErrorResponse.builder()
                .message(errors)
                .path(webRequest.getHeader("Content-Type"))
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .timestamp(LocalDate.now())
                .build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(errorResponse);
    }

    @ExceptionHandler(RoomNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleRoomNotFoundException(RoomNotFoundException e,
                                                                     WebRequest webRequest){
        Map<String, String> errors = new HashMap<>();
        errors.put("message", e.getMessage());

        log.error("Room not found exception", e);
        ErrorResponse errorResponse = ErrorResponse.builder()
                .message(errors)
                .path(webRequest.getHeader("Content-Type"))
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .timestamp(LocalDate.now())
                .build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(errorResponse);
    }

    @ExceptionHandler(LabTestNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleLabTestNotFoundException(LabTestNotFoundException e,
                                                                        WebRequest webRequest){
        Map<String, String> errors = new HashMap<>();
        errors.put("message", e.getMessage());

        log.error("Lab test not found exception", e);
        ErrorResponse errorResponse = ErrorResponse.builder()
                .message(errors)
                .path(webRequest.getHeader("Content-Type"))
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .timestamp(LocalDate.now())
                .build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(errorResponse);
    }

    @ExceptionHandler(BedNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleBedNotFoundException(BedNotFoundException e,
                                                                    WebRequest webRequest){
        Map<String, String> errors = new HashMap<>();
        errors.put("message", e.getMessage());

        log.error("Bed not found exception", e);
        ErrorResponse errorResponse = ErrorResponse.builder()
                .message(errors)
                .path(webRequest.getHeader("Content-Type"))
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .timestamp(LocalDate.now())
                .build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(errorResponse);
    }

    @ExceptionHandler(NoBedAvailableException.class)
    public ResponseEntity<ErrorResponse> handleNoBedAvailableException(NoBedAvailableException e,
                                                                       WebRequest webRequest){
        Map<String, String> errors = new HashMap<>();
        errors.put("message", e.getMessage());

        log.error("No bed available exception", e);
        ErrorResponse errorResponse = ErrorResponse.builder()
                .message(errors)
                .path(webRequest.getHeader("Content-Type"))
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .timestamp(LocalDate.now())
                .build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(errorResponse);
    }

    @ExceptionHandler(OperationNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleOperationNotFoundException(OperationNotFoundException e,
                                                                          WebRequest webRequest){
        Map<String, String> errors = new HashMap<>();
        errors.put("message", e.getMessage());

        log.error("Operation not found exception", e);
        ErrorResponse errorResponse = ErrorResponse.builder()
                .message(errors)
                .path(webRequest.getHeader("Content-Type"))
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .timestamp(LocalDate.now())
                .build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(errorResponse);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<ErrorResponse> handleNoSuchElementException(NoSuchElementException e,
                                                                      WebRequest webRequest) {

        Map<String, String> errors = new HashMap<>();
        errors.put("message", e.getMessage());

        log.error("No such element exception", e);
        ErrorResponse errorResponse = ErrorResponse.builder()
                .message(errors)
                .path(webRequest.getHeader("Content-Type"))
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .timestamp(LocalDate.now())
                .build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(errorResponse);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException e,
                                                                               WebRequest webRequest) {

        Map<String, String> errors = new HashMap<>();

        e.getBindingResult().getFieldErrors().forEach(fieldError ->
                errors.put(fieldError.getField(), fieldError.getDefaultMessage()));

        log.error("Field is not valid : {}", errors);

        ErrorResponse errorResponse = ErrorResponse.builder()
                .message(errors)
                .path(webRequest.getHeader("Content-Type"))
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .timestamp(LocalDate.now())
                .build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(errorResponse);
    }



}
