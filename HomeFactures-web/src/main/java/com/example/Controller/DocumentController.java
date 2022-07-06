package com.example.Controller;


import com.appasso.projet.Document;

import com.appasso.repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.ServerResponse;

import javax.validation.Valid;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class DocumentController {
    @Autowired
    private DocumentRepository documentRepository;
    @GetMapping("/documents")
    public List<Document> getDocument(){
        return documentRepository.findAll();
    }

    @GetMapping("/documents/{id}")
    public ResponseEntity<Document> getDocument(@PathVariable Integer id){
        Optional<Document> document = documentRepository.findById(id);
        return ResponseEntity.ok().body(document.get());
    }

    @DeleteMapping("/documents/{id}")
    public void deleteDocument(@PathVariable Integer id){
        documentRepository.deleteById(id);
    }

    @PostMapping("/documents")
    public ResponseEntity<Document> createDocument(@Valid @RequestBody Document document) throws URISyntaxException {
        if(document.getIdDoc() != null) {
            throw new RuntimeException("un Document ne peux pas avoir le meme ID");
        }
        Document result = documentRepository.save(document);
        return ResponseEntity.created(new URI("/api/documents)"+result.getIdDoc())).body(result);
    }

    @PutMapping("/documents")
        public ResponseEntity<Document> updateDocument(@Valid @RequestBody Document document) throws URISyntaxException{
        if(document.getIdDoc() == null) {
            throw new RuntimeException("ID invalide");
        }
        Document result = documentRepository.save(document);
        return ResponseEntity.ok().body(result);
    }

    /*
    *
    *
    *
    	@PostMapping("/upload")
	public BodyBuilder uplaod File(@RequestParam("File") MultipartFile file) throws IOException {

		Document file= new Documentf(null, file.getOriginalFilename(), file.getContentType()));
		document Repository.save(file);
		return ResponseEntity.status(HttpStatus.OK);
	}
    @GetMapping(path = { "/get/{imageName}" })
	public Justificatif getImage(@PathVariable("imageName") String imageName) throws IOException {
		final Optional<Justificatif> retrievedImage = justificatifRepository.findByName(imageName);
		Justificatif img = new Justificatif(retrievedImage.get().getName(), retrievedImage.get().getType(), decompressBytes(retrievedImage.get().getPicByte()));
		return img;
	}
	// compress the image bytes before storing it in the database
	public static byte[] compressBytes(byte[] data) {
		Deflater deflater = new Deflater();
		deflater.setInput(data);
		deflater.finish();
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
		byte[] buffer = new byte[1024];
		while (!deflater.finished()) {
			int count = deflater.deflate(buffer);
			outputStream.write(buffer, 0, count);
		}
		try {
			outputStream.close();
		} catch (IOException e) {
		}
		System.out.println("Compressed Image Byte Size - " + outputStream.toByteArray().length);
		return outputStream.toByteArray();
	}
	// uncompress the image bytes before returning it to the angular application
	public static byte[] decompressBytes(byte[] data) {
		Inflater inflater = new Inflater();
		inflater.setInput(data);
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
		byte[] buffer = new byte[1024];
		try {
			while (!inflater.finished()) {
				int count = inflater.inflate(buffer);
				outputStream.write(buffer, 0, count);
			}
			outputStream.close();
		} catch (IOException ioe) {
		} catch (DataFormatException e) {
		}
		return outputStream.toByteArray();
	}
    * */

}
