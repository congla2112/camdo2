package poly.com.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import poly.com.entitis.NotificationMessage;
import poly.com.exception.ResourceNotFoundException;
import poly.com.repository.NotificationMessageRepository;

@RestController
@RequestMapping(value = "/api")
public class NotificationMessageController {

	@Autowired
	NotificationMessageRepository notificationMessageRepository;

	@GetMapping("/notificationMessage")
	public List<NotificationMessage> getAllNotifi() {
		return notificationMessageRepository.findAll();
	}

	@PostMapping("/notificationMessage")
	public NotificationMessage createNotifi(@Valid @RequestBody NotificationMessage notificationMessage) {
		return notificationMessageRepository.save(notificationMessage);
	}

	@GetMapping("/notificationMessage/{id}")
	public NotificationMessage getNotifiId(@PathVariable(value = "id") String notifiId) {
		return notificationMessageRepository.findById(notifiId).orElseThrow(
				() -> new poly.com.exception.ResourceNotFoundException("NotificationMessage", "id", notifiId));
	}

	@PutMapping("/notificationMessage/{id}")
	public NotificationMessage updateNotifi(@PathVariable(value = "id") String notifiId,
			@Valid @RequestBody NotificationMessage NotifiDetails) {
		NotificationMessage notificationMessage = notificationMessageRepository.findById(notifiId)
				.orElseThrow(() -> new ResourceNotFoundException("NotificationMessage", "id", notifiId));

		notificationMessage.setId(NotifiDetails.getId());
		notificationMessage.setSender(NotifiDetails.getSender());
		notificationMessage.setReceiver(NotifiDetails.getReceiver());
		notificationMessage.setDate(NotifiDetails.getDate());
		notificationMessage.setContent(NotifiDetails.getContent());
		notificationMessage.setStutas(NotifiDetails.getStutas());

		NotificationMessage upNotificationMessage = notificationMessageRepository.save(notificationMessage);
		return upNotificationMessage;
	}

	@DeleteMapping("/notificationMessage/{id}")
	public ResponseEntity<?> deleteNotifi(@PathVariable(value = "id") String notifiId) {
		NotificationMessage notificationMessage = notificationMessageRepository.findById(notifiId)
				.orElseThrow(() -> new ResourceNotFoundException("NotificationMessage", "id", notifiId));
		notificationMessageRepository.delete(notificationMessage);
		return ResponseEntity.ok().build();
	}

}
