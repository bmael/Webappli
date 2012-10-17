class Zipette
!!!147714.java!!!	getFiles(in archive : String) : ArrayList
        ArrayList fileList = new ArrayList<String>();
        ZipInputStream zipInputStream = null;
        ZipEntry zipEntry = null;
        Long size;

        try {
            zipInputStream = new ZipInputStream(new FileInputStream(archive));
            zipEntry = zipInputStream.getNextEntry();
            while (zipEntry != null) {
                String[] file = new String[3];
                file[0] = zipEntry.getName();
                size = zipEntry.getSize()/1024;
                file[1] = size.toString()+ " ko";
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                file[2] = simpleDateFormat.format(new Date(zipEntry.getTime()));

                fileList.add(file);
                zipEntry = zipInputStream.getNextEntry();
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Zipette.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                zipInputStream.close();
            } catch (IOException ex) {
                Logger.getLogger(Zipette.class.getName()).log(Level.SEVERE, null, ex);
            }
            return fileList;
        }
!!!147842.java!!!	extractTo(in archive : String, in file : String, in destPath : String) : void
        ZipInputStream zipInputStream = null;
        ZipEntry zipEntry = null;
        byte[] buffer = new byte[2048];
       
        zipInputStream = new ZipInputStream(new FileInputStream(archive));
        zipEntry = zipInputStream.getNextEntry();
        while (zipEntry != null) {
            if (zipEntry.getName().equalsIgnoreCase(file)) {
                FileOutputStream fileoutputstream = new FileOutputStream(destPath + file);
                int n;

                while ((n = zipInputStream.read(buffer, 0, 2048)) > -1) {
                    fileoutputstream.write(buffer, 0, n);
                }

                fileoutputstream.close();
                zipInputStream.closeEntry();

            }
            zipEntry = zipInputStream.getNextEntry();
        }
